package api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class OperacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String operacao;

    @Column
    private String num1;

    public OperacaoEntity(Long id, String operacao) {
        this.id = id;
        this.operacao = operacao;
    }

    public OperacaoEntity(){}

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
}
