alter table medicals add column active boolean;
update medicals set active = true;