// Mascara dos campos
jQuery(function($){
		$("#birth").mask("99/99/9999");
		$("#phone").mask("(99) 9999-9999");
		$("#cellphone").mask("(99) 99999-9999");
		$("#zipcode").mask("99999-999");
	});

//Respons�vel por realizar a busca do CEP digitado e popular os demais campos de endere�o
$(function(){

	    /**
	     * Atribuo ao elemento #zipcode, o evento blur
	     * Blur, dispara uma a��o, quando o foco
	     * sair do elemento, no nosso caso cep
	     */
	    $("#zipcode").blur(function(){
	        /**
	         * Resgatamos o valor do campo #cep
	         * usamos o replace, pra remover tudo que n�o for num�rico,
	         * com uma express�o regular
	         */
	        var cep     = $(this).val().replace(/[^0-9]/, '');
	        //Armazena a refer�ncia da div#boxCampos
	        //var boxes   = $("#boxCampos");
	         //Armazena a refer�ncia da div#mensagemErro
	        //var msgErro = $("#mensagemErro");
	        //Verifica se n�o est� vazio
	        if(cep !== ""){
	             //Cria vari�vel com a URL da consulta, passando o CEP
	             var url = 'http://cep.republicavirtual.com.br/web_cep.php?cep='+cep+'&formato=json';
	             /**
	              * Fazemos um requisi��o a URL, como vamos retornar json,
	              * usamos o m�todo $.getJSON;
	              * Que � composta pela URL, e a fun��o que vai retorna os dados
	              * o qual passamos a vari�vel json, para recuperar os valores
	              */
	             $.getJSON(url, function(json){
	                    //Atribuimos o valor aos inputs
	                    $("#street").val(json.tipo_logradouro + ' '+ json.logradouro);
	                    $("#city").val(json.cidade);
	                    $("#state").val(json.uf);
	                    
	                    /**
	                     * Removemos a classe ocultar, para mostrar os campos
	                     * preenchidos
	                     */
	                    boxes.removeClass('ocultar');
	                 
	                    //Usamos o m�todo fail, caso n�o retorne nada
	                }).fail(function(){
	                 //N�o retornando um valor v�lido, ele mostra a mensagem
	                 //msgErro.removeClass('ocultar').html('CEP inexistente')
	            });
	        }
	    });
	});

// Responsavel por habilitar e desabilitar fieldset de company na pagina de cadastro
	$(document).ready(function(){
	  $("input#isOwner").click(function(){
	    $("fieldset.companyHidden").hide("slow",function(){
	    document.register.action = "registerUser";
	    });
	  });
	  $( "input#isOfNGO" ).click(function() {
	    $( "fieldset.companyHidden" ).show( 1500 );
	    document.register.action = "registerNGO";
	  });
	  $( "input#isOfPetShop" ).click(function() {
	    $( "fieldset.companyHidden" ).show( 1500 );
	    document.register.action = "registerPetShop";
	  });
	});