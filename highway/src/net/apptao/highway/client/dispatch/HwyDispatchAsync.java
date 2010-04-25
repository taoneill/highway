package net.apptao.highway.client.dispatch;

import net.apptao.highway.shared.dispatch.HwyCommand;
import net.apptao.highway.shared.dispatch.HwyResult;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HwyDispatchAsync {
	 <C extends HwyCommand<R>, R extends HwyResult> void call(C command, AsyncCallback<R> callback);

		// crazy ideas
	 // maybe the Maps (below) could be replaced with (or alternative to a) a cool syntax e.g. 
	 //hwy.call().batch(new HwyCommand(), new AsyncCallback({
	 //										.. lalala
//										}
	 //			.and(new HwyCommand(), new AsyncCallback({
//									... lalala
	 //									}
	 //			.and(...);
	 // 
	 // replace the "and" with "then" and "next" for the queue and rush 
	 
	 //public void batch(HwyBatchFailBehavior behavior, Map<HwyCommand<HwyResult>, AsyncCallback<HwyResult>> commands, ){
		//		// send as a single request (let fail or rollback whole batch)
		//	}
		//	
		//	public void queue(List<HwyCommand<HwyResult>, AsyncCallback<HwyResult>> commands, HwyQueueFailBehavior behavior){
		//		// wait until each request comes back before sending the next (keep going on fail or stop queue)
		//	}
	 
	 //public void rush(List<HwyCommand<HwyResult>, AsyncCallback<HwyResult>> commands, HwyQueueFailBehavior behavior){
			//		// like a queue _don't_ wait until each request comes back before sending the next, heck, send them all at once in a batch
	 			// trick is: dont serve the Result and the callback until you're sure the previous one in line didnt fail
	 		// 	Overall, it speed up the process but you gotta be sure that actions dont depend on each other cuz they're executing and completing on the server as soon as possible, not waiting for the previous
	 		// would kill the server if abused (e.g. always sending queues 
			//	}
		//	
}
