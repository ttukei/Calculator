package com.company.controller;

import com.company.model.Hexadecimal;
import com.company.model.Decimal;

public interface HexadecimalCalcInterface {

    Hexadecimal decimalToHexadecimal(Decimal decimal);

    Decimal hexadecimalToDecimal(Hexadecimal hexadecimal);
}
