// Mascara dos campos
jQuery(function($){
		$("#birth").mask("99/99/9999");
		$("#phone").mask("(99) 9999-9999");
		$("#cellphone").mask("(99) 99999-9999");
		$("#zipcode").mask("99999-999");
	});

//Responsável por realizar a busca do CEP digitado e popular os demais campos de endereço
$(function(){

	    /**
	     * Atribuo ao elemento #zipcode, o evento blur
	     * Blur, dispara uma ação, quando o foco
	     * sair do elemento, no nosso caso cep
	     */
	    $("#zipcode").blur(function(){
	        /**
	         * Resgatamos o valor do campo #cep
	         * usamos o replace, pra remover tudo que não for numérico,
	         * com uma expressão regular
	         */
	        var cep     = $(this).val().replace(/[^0-9]/, '');
	        //Armazena a referência da div#boxCampos
	        //var boxes   = $("#boxCampos");
	         //Armazena a referência da div#mensagemErro
	        //var msgErro = $("#mensagemErro");
	        //Verifica se não está vazio
	        if(cep !== ""){
	             //Cria variável com a URL da consulta, passando o CEP
	             var url = 'http://cep.republicavirtual.com.br/web_cep.php?cep='+cep+'&formato=json';
	             /**
	              * Fazemos um requisição a URL, como vamos retornar json,
	              * usamos o método $.getJSON;
	              * Que é composta pela URL, e a função que vai retorna os dados
	              * o qual passamos a variável json, para recuperar os valores
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
	                 
	                    //Usamos o método fail, caso não retorne nada
	                }).fail(function(){
	                 //Não retornando um valor válido, ele mostra a mensagem
	                 //msgErro.removeClass('ocultar').html('CEP inexistente')
	            });
	        }
	    });
	});

// Responsavel por habilitar e desabilitar fieldset de company na pagina de cadastro
	$(document).ready(function(){
	  $("input#isOwner").click(function(){
	    $("fieldset.companyHidden").hide("slow",function(){
	    });
	  });
	  $( "input#isOfNGO" ).click(function() {
	    $( "fieldset.companyHidden" ).show( 1500 );
	  });
	  $( "input#isOfPetShop" ).click(function() {
	    $( "fieldset.companyHidden" ).show( 1500 );
	  });
	});