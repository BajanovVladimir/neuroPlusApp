export function radioSelected(radioName){
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

export function modalWindowShow(modalWindow, button){
      console.log('function');
      button.addEventListener('click', () => {
                   console.log(modalWindow);
                   modalWindow.showModal();
      });
}

export function modalWindowShowIfRadioButtonSelected(modalWindow, radioButtonName, button){
     console.log('function');
     button.addEventListener('click', () => {
           if(radioSelected(radioButtonName)){
              console.log(button);
              modalWindow.showModal();
           }
     });
}

export function modalWindowClose(buttonClose, modalWindowClose){
     console.log('function');
     buttonClose.addEventListener('click', () => {
            console.log(modalWindowClose);
            modalWindowClose.close();
     })
}

export function modalWindowSubmit(button,form){
   button.addEventListener('click', () => {
             document.forms[form].submit();
    })
}
