package api.controller;

import api.service.CalculatorService;
import api.entity.OperacaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/basic")
public class OperacaoController {

    @Autowired
    private CalculatorService calcularSevice;

    @GetMapping("/sum")
    public ResponseEntity<Float> sumData(@RequestParam float num1,
                                         @RequestParam float num2){

        return ResponseEntity.ok(calcularSevice.sum(num1, num2));
    }

    @GetMapping("/mult")
    public ResponseEntity<Float> multData(@RequestParam float num1,
                                          @RequestParam float num2){
        return ResponseEntity.ok(
                calcularSevice.mult(num1,num2)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<OperacaoEntity>> findAll(){
        return ResponseEntity.ok(
                calcularSevice.findAll()
        );
    }

    @PostMapping("/media")
    public ResponseEntity<Double> media(@RequestBody List<Integer> numeros) {
        return ResponseEntity.ok(calcularSevice.media(numeros));
    }

    @PostMapping("/menorEMaior")
    public ResponseEntity<int[]> menorEMaior(@RequestBody List<Integer> numeros) {
        return ResponseEntity.ok(calcularSevice.menorEMaior(numeros));
    }

    @PostMapping("/numerosRepetidos")
    public ResponseEntity<List<String>> numerosRepetidos(@RequestBody List<Integer> numeros) {
        return ResponseEntity.ok(calcularSevice.numerosRepetidos(numeros));
    }
}
