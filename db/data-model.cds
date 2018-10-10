namespace jupiterpa.balance;
using jupiterpa as base from './base-model';

entity Account {
  key ID : UUID;
  name : String;
  admin : base.AdminData;
}

entity Transaction {
	key ID:  UUID;
	account : association to Account; 
	amount: base.Amount;
	admin: base.AdminData;
}

entity Balance as 
	SELECT from Transaction 
		{ key account.ID, account.name, sum( amount.value ) as amount : Integer, amount.unit as unit : Integer } 
		group by account.ID, account.name, amount.unit; 