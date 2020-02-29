<template>
  <div class="hello">
    <editor v-model="myValue"
            :init="init"
            :disabled="disabled"
            @onClick="onClick">
    </editor>
  </div>
</template>

<script>
import tinymce from 'tinymce/tinymce'
import Editor from '@tinymce/tinymce-vue'
import 'tinymce/themes/silver'
// 编辑器插件plugins
// 更多插件参考：https://www.tiny.cloud/docs/plugins/
import 'tinymce/plugins/image'// 插入上传图片插件
import 'tinymce/plugins/media'// 插入视频插件
import 'tinymce/plugins/table'// 插入表格插件
import 'tinymce/plugins/lists'// 列表插件
import 'tinymce/plugins/wordcount'// 字数统计插件
export default {
  name: 'HelloWorld',
  components: {
      Editor
    },
    props: {
      value: {
        type: String,
        default: ''
      },
      disabled: {
        type: Boolean,
        default: false
      },
      plugins: {
        type: [String, Array],
        default: 'lists image media table wordcount'
      },
      toolbar: {
        type: [String, Array],
        default: 'undo redo |  formatselect | bold italic forecolor backcolor | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | lists image media table | removeformat'
      }
    },
  data () {

    return {
      //初始化配置
      init: {
        // language_url: '/static/tinymce/langs/zh_CN.js',
        // language: 'zh_CN',
        skin_url: '/static/tinymce/skins/ui/oxide',
        height: 150,
        plugins: this.plugins,
        toolbar: this.toolbar,
        branding: false,
        menubar: false,
        //此处为图片上传处理函数，这个直接用了base64的图片形式上传图片，
        //如需ajax上传可参考https://www.tiny.cloud/docs/configure/file-image-upload/#images_upload_handler
        //images_upload_url:"/common/uploadImg",
        images_upload_handler: function (blobInfo, succFun, failFun) {
        var xhr, formData;
        var file = blobInfo.blob();//转化为易于理解的file对象
        xhr = new XMLHttpRequest();
        xhr.withCredentials = false;
        xhr.open('POST', '/common/uploadImg');
        xhr.onload = function() {
            var json;
            if (xhr.status != 200) {
                failFun('HTTP Error: ' + xhr.status);
                return;
            }
            json = JSON.parse(xhr.responseText);
            if (!json || typeof json.data.urlExt != 'string') {
                failFun('Invalid JSON: ' + xhr.responseText);
                return;
            }
            succFun(json.data.urlExt);
        };
        formData = new FormData();
        formData.append('file', file, file.name );//此处与源文档不一样
        xhr.send(formData);
        },
        file_picker_types: 'file image media',
        file_picker_callback: function(callback, value, meta) {
          // Provide file and text for the link dialog
          //要先模拟出一个input用于上传本地文件
          var input = document.createElement('input');
              input.setAttribute('type', 'file');
              //你可以给input加accept属性来限制上传的文件类型
              //例如：input.setAttribute('accept', '.jpg,.png');
          input.click();
          input.onchange = function() {
              var file = this.files[0];
 
              var xhr, formData;
              console.log(file.name);
              xhr = new XMLHttpRequest();
              xhr.withCredentials = false;
              xhr.open('POST', '/common/uploadImg');
              xhr.onload = function() {
                  var json;
                  if (xhr.status != 200) {
                      failure('HTTP Error: ' + xhr.status);
                      return;
                  }
                  json = JSON.parse(xhr.responseText);
                  if (!json || typeof json.data.urlExt != 'string') {
                      failure('Invalid JSON: ' + xhr.responseText);
                      return;
                  }
                  callback(json.data.urlExt);
              };
              formData = new FormData();
              formData.append('file', file, file.name );
              xhr.send(formData);
          }
        }
      },
      myValue: this.value
    }
  },
  mounted(){
    tinymce.init({})
  },
  methods: {
    //添加相关的事件，可用的事件参照文档=> https://github.com/tinymce/tinymce-vue => All available events
    //需要什么事件可以自己增加
    onClick(e) {
      this.$emit('onClick', e, tinymce)
    },
    //可以添加一些自己的自定义事件，如清空内容
    clear() {
      this.myValue = ''
    }
  },
  watch: {
    value(newValue) {
      this.myValue = newValue
    },
    myValue(newValue) {
      this.$emit('input', newValue)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
