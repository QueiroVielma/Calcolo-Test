package api.service;

import api.entity.OperacaoEntity;
import api.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService {
    @Autowired
    private OperacaoRepository operacaoRepository;

    public float sum(float num1, float num2){
        operacaoRepository.save(new OperacaoEntity(null, "soma"));
        return num1+num2;
    }

    public float mult(float num1, float num2){
        var data = operacaoRepository.save(new OperacaoEntity(null, "multiplicacao"));
        if(data.getId()!=null){
            return num1*num2;
        }
        return 0;
    }

    public List<OperacaoEntity> findAll(){
        return operacaoRepository.findAll();
    }

    public double media(List<Integer> numeros) {
        double soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return soma / numeros.size();
    }

    public int[] menorEMaior(List<Integer> numeros) {
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        for (int numero : numeros) {
            if (numero > maior) {
                maior = numero;
            }
            if (numero < menor) {
                menor = numero;
            }
        }

        return new int[]{menor, maior};
    }

    public List<String> numerosRepetidos(List<Integer> numeros) {
        List<String> repetidos = new ArrayList<>();
        List<Integer> jaVerificados = new ArrayList<>();

        for (int i = 0; i < numeros.size(); i++) {
            int count = 0;
            int numeroAtual = numeros.get(i);

            if (jaVerificados.contains(numeroAtual)) {
                continue;
            }

            for (int j = 0; j < numeros.size(); j++) {
                if (numeroAtual == numeros.get(j)) {
                    count++;
                }
            }

            jaVerificados.add(numeroAtual);

            if (count > 1) {
                repetidos.add(numeroAtual + " aparece " + count + " vezes");
            }
        }

        return repetidos;
    }

}
