import {modalWindowShow} from './utils.js';
import {modalWindowShowIfRadioButtonSelected} from './utils.js';
import {submitFormIfRadioButtonSelected} from './utils.js';
import {modalWindowClose} from './utils.js';
import {modalWindowSubmit} from './utils.js';
import {doubleValidation} from './utils.js';
import {integerValidation} from './utils.js';
//------------------------------------------------------------------
//------------------------ClientCard--------------------------------
  const redirectClientsViewForm = document.querySelector('#redirectClientsViewForm');
  const closeClientCardBtn = document.querySelector('#closeClientCardBtn');
  const showWindowContactAddBtn = document.querySelector('#showWindowAddContactBtn');
  const windowContactAdd = document.querySelector('#modalWindowContactAdd');

  closeClientCardBtn.addEventListener('click', () => {
     redirectClientsViewForm.submit();
  });
  modalWindowShow(windowContactAdd, showWindowAddContactBtn);
//------------------------End ClientCard----------------------------

//-------------------------addContact-------------------------------
 const buttonModalWindowAddContactClose = document.querySelector('#buttonModalWindowAddContactClose');
 const contactAddForm = document.querySelector('#addContactForm');
 const buttonAddContact = document.querySelector('#buttonAddContact');

 modalWindowClose(buttonModalWindowAddContactClose,windowContactAdd);
 buttonAddContact.addEventListener('click', () => {
     contactAddForm.submit();
 });

//------------------------End addContact----------------------------