package cn.kevinz.provider;

import cn.kevinz.provider.model.IndentCheck;
import cn.kevinz.provider.model.IndentCheckResult;
import cn.kevinz.provider.model.CheckedStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class BeerIndentController {
    private static final String NO_REASON = null;
    private static final String TOO_YOUNG = "To young to get beer";
    private static final int THRESHOLD_AMOUNT = 18;

    @RequestMapping(value = "/beer", method = POST)
    public IndentCheckResult orderCheck(@RequestBody IndentCheck indentCheck) {
        if (ageNoMoreThanThreshold(indentCheck)) {
            return new IndentCheckResult(CheckedStatus.NOT_OK, TOO_YOUNG, false);
        }
        return new IndentCheckResult(CheckedStatus.OK, NO_REASON, true);
    }

    private boolean ageNoMoreThanThreshold(IndentCheck indentCheck) {
        return THRESHOLD_AMOUNT > indentCheck.getAge();
    }
}
