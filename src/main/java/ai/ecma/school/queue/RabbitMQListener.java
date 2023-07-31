package ai.ecma.school.queue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMQListener {

    // @RabbitListener(queues = "lmsuniversity.add-students")
    public void receivedStudents(List<?> mqStudentDTOList) {
    }
}
