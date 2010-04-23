package net.apptao.highway.client.dispatch;

public @interface CachedCommand {
	long secondsUntilExpire() default 60;
}
