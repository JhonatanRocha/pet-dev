// Mascara dos campos
jQuery(function($){
		/*$("#birth").mask("99/99/9999");*/
		$("#phone").mask("(99) 9999-9999");
		$("#cellphone").mask("(99) 99999-9999");
		$("#zipcode").mask("99999-999");
		$("#cnpj").mask("99.999.999/9999-99");
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
	                }).fail(function(){
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
	
	// Funcao para validar o tipo de imagem a ser salva no cadastro
	function check_file(){
	    str=document.getElementById('file').value.toUpperCase();
		suffix=".JPG";
		suffix2=".JPEG";
		suffix3 = ".PNG";
		if(!(str.indexOf(suffix, str.length - suffix.length) !== -1||
	           str.indexOf(suffix2, str.length - suffix2.length) !== -1||
	           str.indexOf(suffix3, str.length - suffix3.length) !== -1)){
			   alert('Tipo de arquivo incorreto,\ O arquivo deve ter uma das extensoes: *.jpg,*.jpeg *.png');
			   document.getElementById('file').value='';
		}
	}
	
	// Funcao para fazer reload da foto na pagina
	function previewImage() {
	    var oFReader = new FileReader();
	    oFReader.readAsDataURL(document.getElementById("file").files[0]);

	    oFReader.onload = function (oFREvent) {
	        document.getElementById("uploadPreview").src = oFREvent.target.result;
	    };
	};
	
	// Validacao dos campos obrigatorios register.jsp
	$(document).ready( function() {
	    $("#register").validate({
	        // Define as regras
	        rules:{
	        	"user.name":{
	                // campoNome ser� obrigat�rio (required) e ter� tamanho m�nimo (minLength)
	                required: true, minlength: 2
	            },
	            "user.email":{
	                // campoEmail ser� obrigat�rio (required) e precisar� ser um e-mail v�lido (email)
	                required: true, email: true
	            },
	            "user.password":{
	                // campoEmail ser� obrigat�rio (required) e precisar� ser um e-mail v�lido (email)
	                required: true, minlength: 2
	            },
	            confirmPassword:{
	                // campoMensagem ser� obrigat�rio (required) e ter� tamanho m�nimo (minLength)
	                required: true, minlength: 2
	            },
	            confirmEmail:{
	                // campoMensagem ser� obrigat�rio (required) e ter� tamanho m�nimo (minLength)
	                required: true, minlength: 2
	            }
	        },
	        // Define as mensagens de erro para cada regra
	        messages:{
	        	"user.name":{
	                required: "Digite o seu nome",
	                minLength: "O seu nome deve conter, no m�nimo, 2 caracteres"
	            },
	            "user.email":{
	                required: "Digite o seu e-mail para contato",
	                email: "Digite um e-mail v�lido",
	                minLength: "O seu email deve conter, no m�nimo, 2 caracteres"
	            },
	            "user.password":{
	                required: "Digite a sua senha",
	                email: "Digite a sua senha",
	                minLength: "A sua senha deve conter, no m�nimo, 2 caracteres"
	            },
	            confirmPassword:{
	                required: "Confirme a sua senha",
	                email: "Confirme a sua senha",
	                minLength: "A sua senha deve conter, no m�nimo, 2 caracteres"
	            },
	            confirmEmail:{
	                required: "Confirme seu email",
	                minLength: "O seu email deve conter, no m�nimo, 2 caracteres"
	            }
	        }
	    });
	});
