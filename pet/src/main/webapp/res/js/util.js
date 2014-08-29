// Mascara dos campos
jQuery(function($){
		/*$("#birth").mask("99/99/9999");*/
		$("#phone").mask("(99) 9999-9999");
		$("#cellphone").mask("(99) 99999-9999");
		$("#zipcode").mask("99999-999");
		$("#cnpj").mask("99.999.999/9999-99");
	});

//Responsável por realizar a busca do CEP digitado e popular os demais campos de endereï¿½o
$(function(){

	    /**
	     * Atribuo ao elemento #zipcode, o evento blur
	     * Blur, dispara uma aï¿½ï¿½o, quando o foco
	     * sair do elemento, no nosso caso cep
	     */
	    $("#zipcode").blur(function(){
	        /**
	         * Resgatamos o valor do campo #cep
	         * usamos o replace, pra remover tudo que nï¿½o for numï¿½rico,
	         * com uma expressï¿½o regular
	         */
	        var cep     = $(this).val().replace(/[^0-9]/, '');
	        //Armazena a referï¿½ncia da div#boxCampos
	        //var boxes   = $("#boxCampos");
	         //Armazena a referï¿½ncia da div#mensagemErro
	        //var msgErro = $("#mensagemErro");
	        //Verifica se nï¿½o estï¿½ vazio
	        if(cep !== ""){
	             //Cria variï¿½vel com a URL da consulta, passando o CEP
	             var url = 'http://cep.republicavirtual.com.br/web_cep.php?cep='+cep+'&formato=json';
	             /**
	              * Fazemos um requisiï¿½ï¿½o a URL, como vamos retornar json,
	              * usamos o mï¿½todo $.getJSON;
	              * Que ï¿½ composta pela URL, e a funï¿½ï¿½o que vai retorna os dados
	              * o qual passamos a variï¿½vel json, para recuperar os valores
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
	                // campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
	                required: true, minlength: 2
	            },
	            "user.email":{
	                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
	                required: true, email: true
	            },
	            "user.password":{
	                // campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
	                required: true, minlength: 2
	            },
	            confirmPassword:{
	                // campoMensagem será obrigatório (required) e terá tamanho mínimo (minLength)
	                required: true, minlength: 2
	            },
	            confirmEmail:{
	                // campoMensagem será obrigatório (required) e terá tamanho mínimo (minLength)
	                required: true, minlength: 2
	            }
	        },
	        // Define as mensagens de erro para cada regra
	        messages:{
	        	"user.name":{
	                required: "Digite o seu nome",
	                minLength: "O seu nome deve conter, no mínimo, 2 caracteres"
	            },
	            "user.email":{
	                required: "Digite o seu e-mail para contato",
	                email: "Digite um e-mail válido",
	                minLength: "O seu email deve conter, no mínimo, 2 caracteres"
	            },
	            "user.password":{
	                required: "Digite a sua senha",
	                email: "Digite a sua senha",
	                minLength: "A sua senha deve conter, no mínimo, 2 caracteres"
	            },
	            confirmPassword:{
	                required: "Confirme a sua senha",
	                email: "Confirme a sua senha",
	                minLength: "A sua senha deve conter, no mínimo, 2 caracteres"
	            },
	            confirmEmail:{
	                required: "Confirme seu email",
	                minLength: "O seu email deve conter, no mínimo, 2 caracteres"
	            }
	        }
	    });
	});
