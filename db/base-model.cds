namespace jupiterpa;

type Unit : String(10);
type Amount {
	value : Integer;
	unit : Unit;
}

type AdminData {
	@odata.on.insert: #now		CreatedAt : Timestamp;
	@odata.on.insert: #user		CreatedBy : String(128);
	@odata.on.update: #now		ChangedAt : Timestamp;
	@odata.on.update: #user		ChangedBy : String(128);
}
