package org.automation.driver;

import org.automation.utils.PropertyUtil;

public abstract class AbstractDriverFactory implements DriverFactory {
    protected static final Long IMPLICITLY_TIMEOUT = Long.parseLong(PropertyUtil.get("timeout.implicitly"));
    protected static final Long PAGE_LOAD_TIMEOUT = Long.parseLong(PropertyUtil.get("timeout.load.page"));
}
