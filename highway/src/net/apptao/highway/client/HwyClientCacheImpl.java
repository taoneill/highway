package net.apptao.highway.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.apptao.highway.shared.dispatch.HwyCommand;
import net.apptao.highway.shared.dispatch.HwyResult;

public class HwyClientCacheImpl implements HwyClientCache {

	private Map<HwyCommand<? extends HwyResult>, HwyResult> cache = 
					new HashMap<HwyCommand<? extends HwyResult>, HwyResult>();
	private Map<HwyCommand<? extends HwyResult>, Long> expirationTimes = 
		new HashMap<HwyCommand<? extends HwyResult>, Long>();
	
	public HwyClientCacheImpl(){
	}
	
	@Override
	public <R extends HwyResult> R get(HwyCommand<R> command) {
		if(cache.containsKey(command)){
			if(expirationTimes.containsKey(command)){
				if(expirationTimes.get(command) > new Date().getTime()){
					// expiration still in the future
					return (R) cache.get(command);
				} else {
					// time has expired
					delete(command);
					return null;
				}
					
			} else {
				return (R) cache.get(command);
			}
		}
		return null;
	}

	@Override
	public <R extends HwyResult> void put(HwyCommand<R> command, R result,
			Long secondsUntilExpire) {
		cache.put(command, result);
		expirationTimes.put(command, new Date().getTime() + secondsUntilExpire*1000);
	}

	@Override
	public void delete(HwyCommand<? extends HwyResult> command) {
		cache.remove(command);
		if(expirationTimes.containsKey(command)){
			expirationTimes.remove(command);
		}
	}
}
