import {modalWindowShow} from './utils.js';
import {modalWindowShowIfRadioButtonSelected} from './utils.js';
import {modalWindowClose} from './utils.js';
import {modalWindowSubmit} from './utils.js';
import {doubleValidation} from './utils.js';
import {integerValidation} from './utils.js';

//-----------------------Service ADD------------------------------------
const showDialogAddBtn = document.querySelector('#buttonAdd');
const modalAddWindow = document.querySelector('#modalAddWindow');
const closeModalAddWindowBtn = document.querySelector('#buttonModalAddWindowClose');
const addServiceBtn = document.querySelector('#buttonAddService');
const formAddService = document.querySelector('#serviceAddForm');

modalWindowShow(modalAddWindow, showDialogAddBtn);
modalWindowClose(closeModalAddWindowBtn, modalAddWindow);
buttonAddService.addEventListener('click', () => {
          var input_price = document.querySelector('#price_input').value;
          var input_duration = document.querySelector('#duration_input').value;
          if(doubleValidation(input_price) && integerValidation(input_duration)){
             formAddService.submit();
             return;
          }
          console.log("Validation false");
 })


//---------------------End Service ADD----------------------------------
//---------------------Service delete-----------------------------------
const showDialogDeleteBtn = document.querySelector('#buttonOpenWindowDelete');
const modalDeleteWindow = document.querySelector('#modalDeleteWindow');
const closeModalDeleteWindowBtn = document.querySelector('#closeModalDeleteWindowBtn');
const submitServiceDeleteBtn = document.querySelector('#buttonDeleteService');
modalWindowShowIfRadioButtonSelected(modalDeleteWindow, 'serviceId', showDialogDeleteBtn);
modalWindowClose(closeModalDeleteWindowBtn,modalDeleteWindow);
modalWindowSubmit(submitServiceDeleteBtn,'servicesForm');
//---------------------End Service delete-------------------------------
//----------------------------Cancel------------------------------------
const buttonCanсel = document.querySelector('#buttonCanсel');
const cancelForm = document.querySelector('#cancelForm');

buttonCanсel.addEventListener('click', () => {
  cancelForm.submit();
});
//------------------------End Cancel------------------------------------