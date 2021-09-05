package Driver;
import io.javalin.Javalin;
public class Driver {

	public static void main(String[] args) {
		Javalin app = Javalin.create().start(7000);
		app.get("/", ctx -> ctx.result("Hello World"));
		app.post("/send-data", ctx -> {
			System.out.println(ctx.body());
			//System.out.println(eee.body());
			});
		
		app.get("/hello", eee-> eee.html("Hello Javelin!"));
		app.get("/exception",ctx -> {
			throw new Exception("test");
			});
		app.get("/clients", clients -> clients.html("all clients"));
		//app.exception(Exception.class, (e.ctx) ->{
		//	System.out.println("exception!!!");
		//	ctx.status(500);
		//});
		app.get("/runmethod", ctx -> {
		RunMethod();
		});
			
			
		
		//app.error(e)
		
		}
	
	public static void RunMethod()
	{
		System.out.println("running method");
	}
	
		
	
}
