#!/usr/bin/perl
use strict;
use warnings;
use Data::Dumper;

sub valid
{
	my $num = shift;
    # <char><char><char><char><char><digit><digit><digit><digit><char>
	return $num =~ /^[A-Z]{5}\d{4}[A-Z]$/s? 'YES' : 'NO';
}

# Tail starts here
my $testcases = <>;
for (1..$testcases){
	my $num = <>;
	print valid($num)."\n";
}