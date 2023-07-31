package ai.ecma.school.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * This class is not documented :(
 *
 * @author Muhammad Muminov
 * @since 5/13/2023
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    @Value("${spring.sql.init.mode}")
    private String mode;

    @Value("${spring.profiles.active}")
    private String profile;


    @Override
    public void run(String... args) {
        if (mode.equals("always")) {
        }


        System.err.printf("Sql Init mode is '%s'\n", mode);
    }
}