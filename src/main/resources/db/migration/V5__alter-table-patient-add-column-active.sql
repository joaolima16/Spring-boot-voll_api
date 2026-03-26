alter table patient add column active boolean;
update patient set active = true;