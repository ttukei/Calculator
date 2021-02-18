package com.company.controller;

import com.company.model.Binary;
import com.company.model.Decimal;

public interface BinaryCalcInterface {

    Binary decimalToBinary(Decimal decimal);

    Decimal binaryToDecimal(Binary binary);
}
