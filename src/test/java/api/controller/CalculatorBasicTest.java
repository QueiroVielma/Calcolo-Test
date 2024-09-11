package api.controller;

import api.service.CalculatorService;
import api.entity.OperacaoEntity;
import api.repository.OperacaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CalculatorBasicTest {

    @Autowired
    CalculatorService calculoService;

    @MockBean
    OperacaoRepository operacaoRepository;

    @Test
    @DisplayName("Teste da função para somar dois numeros")
    void sumFunctionTest(){
        Assertions.assertEquals(42, calculoService.sum(24, 18));
        Assertions.assertNotEquals(29, calculoService.sum(24, 18));
    }

    @Test
    @DisplayName(("Testa funcao que retorna tudo"))
    void returnAllTest(){
        List<OperacaoEntity> data = new ArrayList<>();
        data.add(new OperacaoEntity(1L, "soma"));
        data.add(new OperacaoEntity(2L, "soma"));
        data.add(new OperacaoEntity(3L, "subtracao"));

        Mockito.when(operacaoRepository.findAll())
                .thenReturn(data);
        var retornoTestUnitario = calculoService.findAll();
        Assertions.assertNotEquals(2,retornoTestUnitario.size());
    }

    @Test
    @DisplayName("Testa a função de calcular a média")
    void mediaTest() {
        List<Integer> numeros = Arrays.asList(5, 10, 15, 20, 25);
        double resultadoEsperado = 15.0;

        double resultado = calculoService.media(numeros);

        Assertions.assertEquals(resultadoEsperado, resultado, 0.001, "A média calculada deve ser igual ao resultado esperado.");
    }

    @Test
    @DisplayName("Testa a função de identificar o menor e o maior valor")
    void menorEMaiorTest() {
        List<Integer> numeros = Arrays.asList(7, 2, 14, 8, 3, 19, 4, 11, 5);
        int[] resultadoEsperado = {2, 19}; // menor = 2, maior = 19

        int[] resultado = calculoService.menorEMaior(numeros);

        Assertions.assertArrayEquals(resultadoEsperado, resultado, "O menor e o maior valor devem estar corretos.");
    }

    @Test
    @DisplayName("Testa a função de identificar números repetidos")
    void numerosRepetidosTest() {
        List<Integer> numeros = Arrays.asList(9, 8, 7, 8, 9, 6, 5, 9);
        List<String> resultadoEsperado = Arrays.asList("9 aparece 3 vezes", "8 aparece 2 vezes");

        List<String> resultado = calculoService.numerosRepetidos(numeros);

        Assertions.assertEquals(resultadoEsperado, resultado, "A lista de números repetidos deve estar correta.");
    }



}
