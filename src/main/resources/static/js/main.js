const showDialogBtnForUsers = document.querySelector('#showDialogButtonForUsers');
const modalDeleteWindowForUsers = document.querySelector('#modalDeleteWindowForUsers');
const closeModalDeleteWindowBtnForUsers = document.querySelector('#buttonCloseForUsers');
const deleteBtnForUsers = document.querySelector('#buttonDeleteForUsers');

function radioSelected(radioName){
      var nameRadio = document.getElementsByName(radioName);
      var resultRadio = undefined;
      var selected = false;
      for (var i = 0; i < nameRadio.length; i++) {
           if (nameRadio[i].type === 'radio' && nameRadio[i].checked) {
                 resultRadio = nameRadio[i].value;
           }
      }
      if(resultRadio != undefined){
          selected = true;
      }
      return selected;
}

function modalWindowShow(modalWindow, radioButtonName, button){
     button.addEventListener('click', () => {
           if(radioSelected(radioButtonName)){
              modalWindow.showModal();
           }
     });
}

function modalWindowClose(buttonClose, modalWindowClose){
     buttonClose.addEventListener('click', () => {
            modalWindowClose.close();
     })
}

function modalWindowFormSubmit(button, form){
   button.addEventListener('click', () => {
             document.forms[form].submit();
    })
}


//-----------------------User------------------------------------

modalWindowShow(modalDeleteWindowForUsers,'userIdForUsers',showDialogBtnForUsers);

modalWindowClose(closeModalDeleteWindowBtnForUsers,modalDeleteWindowForUsers);

//modalWindowFormSubmit(deleteBtnForUser,'userDeleteFormForUser');

//---------------------End User----------------------------------