### RestFul风格
中文释义为表现层状态转换(名字挺高大上的) 它不是一种标准 而是一种设计风格 它的主要作用是充分并正确利用HTTP协议的特性 规范资源获取URL路径 通俗的讲
RestFul风格的设计允许将参数通过URL拼接传到服务端 目的是让URL看起来更简洁实用 并且我们可以充分利用多种HTTP请求方式(POST/GET/PUT/DELETE) 来执行相同请求地址的不同类型操作

因此 这种风格的连接 我们就可以直接从请求路径中读取参数 比如:

    http://localhost:8080/mvc/index/123456

我们可以直接将index的下一级路径作为请求参数进行处理 也就是说现在的请求参数包含在了请求路径中:

```java
                    @RequestMapping("/index/{str}")
                    public String index(@PathVariable String str) {
    
                        System.out.println(str);
                        return "index";
                        
                    }
```

注意: 请求路径我们可以手动添加类似占位符一样的信息 这样占位符位置的所有内容都会被作为请求参数
而方法的形参列表中必须包括一个与占位符同名的并且添加了@PathVariable注解的参数 或是由@PathVariable注解指定为占位符名称:

```java
                    @RequestMapping("/index/{str}")
                    public String index(@PathVariable("str") String text) {
    
                        System.out.println(text);
                        return "index";
                        
                    }
```

如果没有配置正确 方法名称上会出现黄线

我们可以按照不同功能进行划分:
- POST http://localhost:8080/mvc/index - 添加用户信息 携带表单数据
- GET http://localhost:8080/mvc/index/{id} - 获取用户信息 id直接放在请求路径中
- PUT http://localhost:8080/mvc/index - 修改用户信息 携带表单数据
- DELETE http://localhost:8080/mvc/index/{id} - 删除用户信息 id直接放在请求路径中

我们分别写四个请求映射:

```java
                    @Controller
                    public class MainController {
                    
                        @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
                        public String get(@PathVariable("id") String text) {
                            
                            System.out.println("获取用户: " + text);
                            return "index";
                            
                        }
                    
                        @RequestMapping(value = "/index", method = RequestMethod.POST)
                        public String post(String username) {
                            
                            System.out.println("添加用户: " + username);
                            return "index";
                            
                        }
                    
                        @RequestMapping(value = "/index/{id}", method = RequestMethod.DELETE)
                        public String delete(@PathVariable("id") String text) {
                            
                            System.out.println("删除用户: " + text);
                            return "index";
                            
                        }
                    
                        @RequestMapping(value = "/index", method = RequestMethod.PUT)
                        public String put(String username) {
                            
                            System.out.println("修改用户: " + username);
                            return "index";
                            
                        }
                        
                    }
```

这只是一种设计风格而已 各位小伙伴了解即可