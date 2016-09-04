/***** Funções prontas ao carregar a pagina  */

$(function(){

    $(".money").maskMoney({decimal:',', // Separador do decimal precision:2, // Precisão
        thousands:'.', // Separador para os milhares
        //prefix:'R$ ', // Simbolo
        //showSymbol:true, // Exibe/Oculta o símbolo
        allowZero:true, // Permite que o digito 0 seja o primeiro caractere
        defaultZero:true // Exibe Mascara padrão mostrando 0
    });

    $('[rel="tooltip"]').tooltip();

});

/***** Funções prontas ao carregar a pagina*/


/***** Modal Do bootstrap */

$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
	var button = $(event.relatedTarget);
	var codigo = button.data('codigo');
	var razaoSocial = button.data('nome');
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')){
		action += '/';
	}
	form.attr('action',action + codigo);

	modal.find('.modal-body span').html('Tem certeza que deseja excluir o cliente <strong>'+razaoSocial+'</strong>?');
});

/***** Modal Do bootstrap */