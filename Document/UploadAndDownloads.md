### 实现文件上传和下载
利用SpringMVC 我们可以很轻松地实现文件上传和下载 我们需要在MainInitializer中添加一个新的方法:

```java
                    public class MainInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
                    
                        ...
                    
                        @Override
                        protected void customizeRegistration(ServletRegistration.Dynamic registration) {
                          	// 直接通过registration配置Multipart相关配置 必须配置临时上传路径 建议选择方便打开的
                            // 同样可以设置其他属性: maxFileSize,maxRequestSize,fileSizeThreshold
                            registration.setMultipartConfig(new MultipartConfigElement("/Users/nagocoler/Download"));
                        }
                        
                    }
```

接着我们直接编写Controller即可:

```java
                    @RequestMapping(value = "/upload", method = RequestMethod.POST)
                    @ResponseBody
                    public String upload(@RequestParam MultipartFile file) throws IOException {
    
                        File fileObj = new File("test.png");
                        file.transferTo(fileObj);
                        System.out.println("用户上传的文件已保存到: " + fileObj.getAbsolutePath());
                        return "文件上传成功";
                        
                    }
```

最后在前端添加一个文件的上传点:

```html
                    <div>
                        <form action="upload" method="post" enctype="multipart/form-data">
                            <input type="file" name="file">
                            <input type="submit">
                        </form>
                    </div>
```

这样 点击提交之后 文件就会上传到服务器了

下载其实和我们之前的写法大致一样 直接使用HttpServletResponse 并向输出流中传输数据即可

```java
                    @RequestMapping(value = "/download", method = RequestMethod.GET)
                    @ResponseBody
                    public void download(HttpServletResponse response){
    
                        response.setContentType("multipart/form-data");
                        try(OutputStream stream = response.getOutputStream();
                            InputStream inputStream = new FileInputStream("test.png")){
                            IOUtils.copy(inputStream, stream);
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        
                    }
```

在前端页面中添加一个下载点:

```html
                    <a href="download" download="test.png">下载最新资源</a>
```