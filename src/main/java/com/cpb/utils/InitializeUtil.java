package com.cpb.utils;
/*
  User: Yemao Luo
  Date: 2022/4/5
  Time: 21:47
*/

import ai.djl.Device;
import ai.djl.MalformedModelException;
import ai.djl.inference.Predictor;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.output.DetectedObjects;
import ai.djl.modality.cv.transform.Resize;
import ai.djl.modality.cv.transform.ToTensor;
import ai.djl.modality.cv.translator.YoloV5Translator;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelNotFoundException;
import ai.djl.repository.zoo.ModelZoo;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.translate.Translator;
import com.cpb.domain.UtilInputs;

import java.io.IOException;

public class InitializeUtil {

    public Translator<Image, DetectedObjects> initializeTranslator(String name, int width, int height) {
        return YoloV5Translator.builder()
                .optSynsetArtifactName(name)
                .addTransform(new Resize(width, height))
                .addTransform(new ToTensor())
                .build();
    }

    public Criteria<Image, DetectedObjects> initializeCriteria(String path, String ModelName, String ClassName, int width, int height) {
        return Criteria.builder()
                .setTypes(Image.class, DetectedObjects.class)
                .optDevice(Device.cpu())
                .optModelUrls(path)
                .optModelName(ModelName)
                .optTranslator(initializeTranslator(ClassName, width, height))
                .optEngine("PyTorch")
                .build();
    }

    public ZooModel<Image, DetectedObjects> initializeModel(String path, String ModelName, String ClassName, int width, int height) {
        try {
            return ModelZoo.loadModel(initializeCriteria(path, ModelName, ClassName, width, height));
        } catch (ModelNotFoundException | MalformedModelException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Predictor<Image, DetectedObjects> initializePredictor(UtilInputs input) {
        return initializeModel(input.getPath(), input.getModelName(), input.getClassName(), input.getWidth(), input.getHeight()).newPredictor();
    }
}
