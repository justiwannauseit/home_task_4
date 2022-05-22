package otus.core.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceItemJson {
    private Integer score;
    private CourseJson course;
    private Integer id;
}