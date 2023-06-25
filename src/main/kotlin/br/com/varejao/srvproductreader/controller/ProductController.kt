package br.com.varejao.srvproductreader.controller

import br.com.varejao.srvproductreader.model.Product
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI

private const val ONLY_ONE_PARAMETER_ERROR = "Forneça apenas um dos parâmetros de consulta: barCode, id ou name"

@RestController
@RequestMapping("/product")
class ProductController {

    @PostMapping
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> {
        return ResponseEntity.created(URI("/product/${product.id}")).body(product);
    }

    @GetMapping
    fun getProduct(
            @RequestParam(required = false) barCode: String?,
            @RequestParam(required = false) id: Long?,
            @RequestParam(required = false) name: String?
    ): ResponseEntity<Product> {
        val providedParams = listOfNotNull(barCode, id, name)
        if (providedParams.size != 1) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(Product());

    }


}