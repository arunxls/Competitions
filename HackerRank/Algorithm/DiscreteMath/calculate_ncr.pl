#!/usr/bin/perl
use strict;
use warnings;
use integer;

sub modInverse{
	my ($a,$b) = @_;
	my $q = $b/$a;
	my $r = $b%$a;
	return ( 1, 1) if $r == 1;
	my ($val1pre, $val2pre) = modInverse($r,$a);
	my $val1 = $val2pre;
	my $val2 = $q*$val2pre + $val1pre;
	return($val1, $val2);
}

sub modBinomial
{
	my ($n,$r,$m) = @_;

	my $num = 1;
	$num 	= ($num*$_)%$m foreach ($r+1..$n);

	my $den = 1;
	$den 	= ($den*$_)%$m foreach (2..$r);

	my ($foo,$bar) = (modInverse($den,$m))%$m;

	return ($num*$bar)%$m
}


sub calculate
{
	my ($n,$r) = @_;
	return modBinomial($n,$r,142857);
}


# Tail starts here
# my $test_cases = <>;
# for (my $index = 0; $index < $test_cases; $index++)
# {
#     my $input = <>;
# 	print ncr(split(' ',$input))."\n";
# }

print calculate(100,100/2);
# my ($foo,$bar) = modInverse(322,701);
# print $bar;
# get_comb(1000);