webpackJsonp([1],{"7Otq":function(e,t,o){e.exports=o.p+"static/img/logo.02b0a6f.png"},NHnr:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=o("7+uW"),a=o("mtWM"),r=o.n(a),l={name:"HelloWorld",data:function(){return{msg:"Ocean Swagger to Doc",docType:"",swaggerUrl:""}},methods:{doOut:function(){var e=this.docType,t=this.swaggerUrl;if(/^(?:http(s)?:\/\/)?[\w.-]+(?:\.[\w\.-]+)+[\w\-\._~:/?#[\]@!\$&'\*\+,;=.]+$/.test(t))if(""!==e){var o=t.replace(":","").replace("/",""),n="";n="Markdown"===e?".md":"Confluence"===e?".txt":".adoc",r()({url:"/out",method:"post",dataType:"json",contentType:"application/json",data:{url:t,docType:e},responseType:"blob"}).then(function(e){console.log(e);var t=window.URL.createObjectURL(new Blob([e.data])),a=document.createElement("a");a.href=t,a.setAttribute("download",o+n),document.body.appendChild(a),a.click()}).catch(function(e){console.log(e)})}else alert("需选择文档类型");else alert("需输入合法的url")}}},s={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"hello"},[o("h1",{staticStyle:{color:"orange"}},[e._v(e._s(e.msg))]),e._v(" "),o("br"),o("br"),o("br"),e._v(" "),o("div",[e._v("swagger地址:\n    "),o("input",{directives:[{name:"model",rawName:"v-model",value:e.swaggerUrl,expression:"swaggerUrl"}],staticClass:"input_css",attrs:{type:"text",placeholder:"如http://127.0.0.1:8080/v2/api-docs"},domProps:{value:e.swaggerUrl},on:{input:function(t){t.target.composing||(e.swaggerUrl=t.target.value)}}})]),o("br"),e._v(" "),o("div",[e._v("选择文档类型:\n    "),o("select",{directives:[{name:"model",rawName:"v-model",value:e.docType,expression:"docType"}],attrs:{"aria-placeholder":"请选"},on:{change:function(t){var o=Array.prototype.filter.call(t.target.options,function(e){return e.selected}).map(function(e){return"_value"in e?e._value:e.value});e.docType=t.target.multiple?o:o[0]}}},[o("option",{attrs:{value:""}},[e._v("-----------请选择一种想要的文档类型-----------")]),e._v(" "),o("option",{attrs:{selected:"",value:"Markdown"}},[e._v("Markdown(文件格式为.md的文档))")]),e._v(" "),o("option",{attrs:{value:"Confluence"}},[e._v("Confluence(文件格式为.txt的wiki文档)")]),e._v(" "),o("option",{attrs:{value:"AsciiDocs"}},[e._v("AsciiDocs(文件格式为.adoc的文档)")])])]),o("br"),e._v(" "),o("div",[o("button",{staticClass:"btClass",on:{click:e.doOut}},[e._v("生成并下载")])]),o("br")])},staticRenderFns:[]};var c={name:"App",components:{HelloWorld:o("VU/8")(l,s,!1,function(e){o("QMR/")},"data-v-182dcfa3",null).exports}},i={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("img",{attrs:{src:o("7Otq")}}),this._v(" "),t("HelloWorld")],1)},staticRenderFns:[]};var p=o("VU/8")(c,i,!1,function(e){o("PBzm")},null,null).exports;n.a.config.productionTip=!1,new n.a({el:"#app",components:{App:p},template:"<App/>"})},PBzm:function(e,t){},"QMR/":function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.43ef1c39aec85a94a486.js.map