package com.cpb.service;
/*
  User: Yemao Luo
  Date: 2022/4/5
  Time: 21:53
*/

import com.cpb.domain.Predict;

import java.io.File;

public interface DetectService {

    public Predict detect(File file);
}
