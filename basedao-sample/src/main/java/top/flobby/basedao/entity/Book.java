package top.flobby.basedao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : Flobby
 * @program : basedao-sample
 * @description : 实体类
 * @create : 2021-11-15 08:38
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;
    private String isbn;
    private String name;
    private Double price;
    private LocalDate published;
}
