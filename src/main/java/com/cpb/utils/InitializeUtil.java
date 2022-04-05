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
import sun.applet.Main;

import java.io.IOException;

public class InitializeUtil {

    public Translator<Image, DetectedObjects> initializeTranslator() {
        return YoloV5Translator.builder()
                .optSynsetArtifactName("QRCode.names")
                .addTransform(new Resize(640, 640))
                .addTransform(new ToTensor())
                .build();
    }

    public Criteria<Image, DetectedObjects> initializeCriteria() {
        return Criteria.builder()
                .setTypes(Image.class, DetectedObjects.class)
                .optDevice(Device.cpu())
                .optModelUrls(Main.class.getResource("/weights").getPath())
                .optModelName("QRCode.torchscript")
                .optTranslator(initializeTranslator())
                .optEngine("PyTorch")
                .build();
    }

    public ZooModel<Image, DetectedObjects> initializeModel() {
        try {
            return ModelZoo.loadModel(initializeCriteria());
        } catch (ModelNotFoundException | MalformedModelException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Predictor<Image, DetectedObjects> initializePredictor() {
        return initializeModel().newPredictor();
    }
}
