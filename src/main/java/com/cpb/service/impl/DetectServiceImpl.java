package com.cpb.service.impl;
/*
  User: Yemao Luo
  Date: 2022/4/5
  Time: 21:55
*/

import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.modality.cv.output.DetectedObjects;
import ai.djl.translate.TranslateException;
import com.cpb.domain.Predict;
import com.cpb.domain.UtilInputs;
import com.cpb.service.DetectService;
import com.cpb.utils.InitializeUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DetectServiceImpl implements DetectService {

    public Predict detect(File file, UtilInputs input) {
        InitializeUtil initializeUtil = new InitializeUtil();
        Predictor<Image, DetectedObjects> predictor = initializeUtil.initializePredictor(input);
        FileInputStream stream = null;
        Predict result = new Predict();
        try {
            stream = new FileInputStream(file);
            Image img = ImageFactory.getInstance().fromInputStream(stream);
            DetectedObjects predict = predictor.predict(img);
            if (predict == null) {
                return null;
            } else {
                Classifications.Classification best = predict.best();
                result.setProbability(best.getProbability());
                result.setClassName(best.getClassName());
                return result;
            }
        } catch (IOException | TranslateException e) {
            e.printStackTrace();
            return null;
        }
    }
}
