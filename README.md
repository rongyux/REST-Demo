　　理解一个新的技术，无疑就是使用它了，下面我们就通过一个可执行的demo来展现REST的原理和使用。

　　1.1 服务器端

　　1 主程序MainServer.java负责启动一个REST服务组件，并设置端口号，创建主路径/threshold及子路径（见步骤2），最后start启动即可。

public class MainServer extends Application {

    public static void main(String[] args) throws Exception {

        Component com = new Component();
        com.getServers().add(Protocol.HTTP, 12345);
        com.getDefaultHost().attach("/threshold", new ThresholdApplication());
        com.start();
    }
}

　　2ThresholdApplicatio.java文件，增添路由， /threshold路径下新增三个路径，/threshold/register /threshold/metricRegister 和 /threshold/info

public class ThresholdApplication extends WadlApplication {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext()) ;
        router.attach("/register" ,RegisterResource.class);
        router.attach("/metricRegister" ,MetricResource.class);
        router.attach("/info" ,InfoResource.class);
        return router;
    }
}

　　3InfoResource.java文件，为路径/threshold/register实现get和post接口，post方式需要解读参数。

public class InfoResource extends WadlServerResource{
    @Get
    public Representation method1() throws ResourceException {
        return new StringRepresentation("Info Register Success! Get Method");
    }

    @Post
    public Representation method2(Representation entity)  
            throws ResourceException {
        String result = getRequest().getEntityAsText();
        System.out.println(result);
        return new StringRepresentation("Info Register Success! Post Method");
    }
}

　　4MetricResourc.java文件，原理同步骤3

public class MetricResource extends WadlServerResource{
    @Get
    public Representation method1() throws ResourceException {
        return new StringRepresentation("Metric Register Success! Get Method");
    }

    @Post
    public Representation method2(Representation entity)  
            throws ResourceException {
        String result = getRequest().getEntityAsText();
        System.out.println(result);
        return new StringRepresentation("Metric Register Success! Post Method");
    }
}

　　5原理同步骤3

public class RegisterResource extends WadlServerResource{
    @Get
    public Representation method1() throws ResourceException {
        return new StringRepresentation("Register Success! Get Method");
    }

    @Post
    public Representation method2(Representation entity)  
            throws ResourceException {
        String result = getRequest().getEntityAsText();
        System.out.println(result);
        return new StringRepresentation("Register Success! Post Method");
    }
}

　　1.2 客户端

　　测试程序TestClient.java，扮演客户端的角色，请求服务器url.

public class TestClient {

    @Test
    public void test01() throws IOException{
        ClientResource client = new ClientResource("http://localhost:12345/threshold/register");
        Representation result =  client.get() ;        
        System.out.println(result.getText());  
    }
    
    @Test
    public void test02() throws IOException{
        ClientResource client = new ClientResource("http://localhost:12345/threshold/register"); 
        Gson gson = new Gson();
        String str =gson.toJson("1");
        Representation result =  client.post(str) ;    
        System.out.println(result.getText());  
    }
    @Test
    public void test03() throws IOException{
        ClientResource client = new ClientResource("http://localhost:12345/threshold/metricRegister");
        Representation result =  client.get() ;        
        System.out.println(result.getText());  
    }
    
    @Test
    public void test04() throws IOException{
        ClientResource client = new ClientResource("http://localhost:12345/threshold/metricRegister"); 
        Gson gson = new Gson();
        String str =gson.toJson("1");
        Representation result =  client.post(str) ;    
        System.out.println(result.getText());  
    }
    @Test
    public void test05() throws IOException{
        ClientResource client = new ClientResource("http://localhost:12345/threshold/info");
        Representation result =  client.get() ;        
        System.out.println(result.getText());  
    }
    
    @Test
    public void test06() throws IOException{
        ClientResource client = new ClientResource("http://localhost:12345/threshold/info"); 
        Gson gson = new Gson();
        String str =gson.toJson("1");
        Representation result =  client.post(str) ;    
        System.out.println(result.getText());  
    }
    
}

　　1.3测试和结果

　　1先启动服务器程序，执行main文件

　　2执行客户端请求，单元测试程序

　　get方式的单元测试1的结果如下：

　　备注：项目源码，后期本人会放在github上，https://github.com/rongyux/REST-Demo

 

 

　 请参考本人博客：

　　http://www.cnblogs.com/rongyux/p/5685611.html

 

 
