package com.cpb.service;
/*
  User: Yemao Luo
  Date: 2022/4/5
  Time: 21:53
*/

import com.cpb.domain.Predict;
import com.cpb.domain.UtilInputs;

import java.io.File;

public interface DetectService {

    Predict detect(File file, UtilInputs input);
}
