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

export function submitFormIfRadioButtonSelected(radioButton, form, submitButton){
     submitButton.addEventListener('click', () => {
         if(radioSelected(radioButton)){
            form.submit();
         }
     })
}

export function modalWindowClose(buttonClose, modalWindowClose){
     console.log('function');
     buttonClose.addEventListener('click', () => {
            console.log("button close");
            modalWindowClose.close();
     })
}

export function modalWindowSubmit(button,form){
   button.addEventListener('click', () => {
      console.log("submit");
             document.forms[form].submit();
    })
}

export function doubleValidation(value){
   return !isNaN(parseFloat(value)) && isFinite(value);
}

export function integerValidation(value){
   var number = Number(value);
   var valid = Number.isInteger(number);
   return valid;
}
