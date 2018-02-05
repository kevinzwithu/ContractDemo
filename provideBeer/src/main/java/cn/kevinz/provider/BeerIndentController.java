package cn.kevinz.provider;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerIndentController {
    private static final String NO_REASON = null;
    private static final String TOO_YOUNG = "To young to get the beer";

    public IndentCheckResult orderCheck(@RequestBody IndentCheck indentCheck) {
        if (ageNoMoreThanThreshold(indentCheck)) {
            return new IndentCheckResult(IndentCheckStatus.NOT_OK, TOO_YOUNG);
        }
        return new IndentCheckResult(IndentCheckStatus.OK, NO_REASON);
    }

    private boolean ageNoMoreThanThreshold(IndentCheck indentCheck) {
        return THRESHOLD_AMOUNT.compareTo(IndentCheck.getAge()) < 0;
    }
}
