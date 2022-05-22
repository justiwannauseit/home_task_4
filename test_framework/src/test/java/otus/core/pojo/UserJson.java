package otus.core.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJson {
    private List<PerformanceItemJson> performance;
    private String name;
    private Integer id;
    private String email;
    private Integer age;
}