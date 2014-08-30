function startLightBox(formId, context, widthFrame, heightFrame){

	importCss(context);

	var divBack = document.createElement("div");
	divBack.id = "overlay-bcash";	
	document.body.appendChild(divBack);

	var center = document.createElement("center");
	divBack.appendChild(center);

	var divLightBox = document.createElement("div");
	divLightBox.id = "lightbox";

	if(widthFrame!=null)
		divLightBox.style.width = widthFrame+"px";

	if(heightFrame!=null)
		divLightBox.style.height = heightFrame+"px";
	
	center.appendChild(divLightBox);

	var iFrame = document.createElement("iFrame");
	iFrame.id = "iFrameBcash";
	iFrame.name = "iFrameBcash";

	divLightBox.appendChild(iFrame);

	var doc = null;
	   if(iFrame.contentDocument)
	      // Firefox, Opera
	      doc = iFrame.contentDocument;
	   else if(iFrame.contentWindow)
	      // Internet Explorer
	      doc = iFrame.contentWindow.document;
	   else if(iFrame.document)
	      // Others?
	      doc = iFrame.document;
	 
	   if(doc == null)
	      throw "Document not initialized";

	doc.open();
	doc.close();
	 
	var divDoc = doc.createElement("div");
	var form = document.getElementById(formId);
	form.setAttribute('action', 'https://www.bcash.com.br/checkout/pay/');
	doc.body.appendChild(form);

	var docForm =   doc.getElementById(formId);

	divDoc.innerHTML = "Sua compra está em processo de finalização.<br/>Caso a página de finalização de pagamento não se inicie automaticamente ";
	
	var aSubmit=document.createElement("a");
	aSubmit.href="javascript:void(0)";
	aSubmit.innerHTML = 'clique aqui';
	aSubmit.setAttribute('onclick', docForm.submit());
	divDoc.appendChild(aSubmit);

	doc.body.appendChild(divDoc);

	docForm.submit();
	
}

function importCss(context){
	var $ = document; // shortcut
	var cssId = 'lightbox-style';  // you could encode the css path itself to generate id..
	if (!$.getElementById(cssId))
	{
    	var head  = $.getElementsByTagName('head')[0];
    	var link  = $.createElement('link');
    	link.id   = cssId;
    	link.rel  = 'stylesheet';
    	link.type = 'text/css';
    	link.href = context+'/res/css/lightbox-style.css';
    	link.media = 'all';
    	head.appendChild(link);
	}
}