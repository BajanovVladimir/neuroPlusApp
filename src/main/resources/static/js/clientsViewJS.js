import {modalWindowShow} from './utils.js';
import {modalWindowShowIfRadioButtonSelected} from './utils.js';
import {submitFormIfRadioButtonSelected} from './utils.js';
import {modalWindowClose} from './utils.js';
import {modalWindowSubmit} from './utils.js';
import {doubleValidation} from './utils.js';
import {integerValidation} from './utils.js';

//------------------------------Client add----------------------
const showDialogAddBtn = document.querySelector('#buttonAdd');
const modalAddWindow = document.querySelector('#modalAddWindow');
const closeModalAddWindowBtn = document.querySelector('#buttonModalAddWindowClose');
const formAddClient = document.querySelector('#clientAddForm');
const addClientBtn = document.querySelector('#buttonAddClient');

modalWindowShow(modalAddWindow, showDialogAddBtn);
modalWindowClose(closeModalAddWindowBtn, modalAddWindow);
addClientBtn.addEventListener('click', () => {
   formAddClient.submit();
});
//------------------------------End client add-----------------

//-----------------Employee card show-----------------------------------------------

const showClientCardBtn = document.querySelector('#buttonOpenClientCard');
const clientsForm = document.querySelector('#clientsForm');

submitFormIfRadioButtonSelected('clientId', clientsForm, showClientCardBtn);
//-------------------End Employee card show------------------------------------------
//----------------------------Cancel------------------------------------
const buttonCanсel = document.querySelector('#buttonCanсel');
const cancelForm = document.querySelector('#cancelForm');

buttonCanсel.addEventListener('click', () => {
  cancelForm.submit();
});
//------------------------End Cancel------------------------------------