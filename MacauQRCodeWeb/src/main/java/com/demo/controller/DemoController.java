package com.demo.controller;
/*
  User: Yemao Luo
  Date: 2022/4/7
  Time: 10:36
*/

import com.cpb.domain.Predict;
import com.cpb.domain.UtilInputs;
import com.cpb.service.DetectService;
import com.cpb.service.impl.DetectServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

   @RequestMapping("/upload")
   public List upload(@RequestParam("uploadFile") MultipartFile multipartfile){
      long time1 = System.currentTimeMillis();
      List<String> result = new ArrayList<>();
      DetectService service = new DetectServiceImpl();
      UtilInputs input = new UtilInputs();
      input.setHeight(640);
      input.setWidth(640);
      input.setModelName("QRCode.torchscript");
      input.setClassName("QRCOde.names");
      input.setPath("file:/ + ${Your own weights folder path}");
      File file = MultipartFileToFile(multipartfile);
      Predict detect = service.detect(file, input);
      result.add(detect.toString());
      long time2 = System.currentTimeMillis();
      result.add(String.valueOf(time2 - time1) + " ms ");
      return result;
   }

   public static File MultipartFileToFile(MultipartFile multiFile) {
      String fileName = multiFile.getOriginalFilename();
      String prefix = fileName.substring(fileName.lastIndexOf("."));

      try {
         File file = File.createTempFile(fileName, prefix);
         multiFile.transferTo(file);
         return file;
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
}
