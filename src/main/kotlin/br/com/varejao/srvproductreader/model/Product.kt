package br.com.varejao.srvproductreader.model

import lombok.Data
import java.math.BigDecimal

class Product {


    var id: String = "";
    var name: String = "";
    var description: String = "";
    var weight: BigDecimal = BigDecimal.ZERO;
    var wightUnitOfMeasurement: String = "";
    var value: BigDecimal = BigDecimal.ZERO;


}