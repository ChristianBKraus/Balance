namespace jupiterpa.balance;

entity Account {
  key ID : Integer;
  name : String;
}

entity Transaction {
	key ID:  Integer;
	account : association to Account; 
	amount: Integer;
}

entity Balance as SELECT from Transaction { key account.ID, account.name, sum( amount ) as amount : Integer } group by account.ID, account.name; 