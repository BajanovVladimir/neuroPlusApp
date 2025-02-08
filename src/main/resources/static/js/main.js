const showDialogBtn = document.querySelector('#showDialogButton');
const modalDeleteWindow = document.querySelector('#modalDeleteWindow');
const closeModalDeleteWindowBtn = document.querySelector('#buttonClose');
const deleteBtn = document.querySelector('#buttonDelete');

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

showDialogBtn.addEventListener('click', () => {
      if(radioSelected('userId')){
         modalDeleteWindow.showModal();
      }

});

closeModalDeleteWindowBtn.addEventListener('click', () => {
       modalDeleteWindow.close();
})

deleteBtn.addEventListener('click', () => {
         document.forms["userDeleteForm"].submit();
})