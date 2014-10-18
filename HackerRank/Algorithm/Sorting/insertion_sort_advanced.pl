#!/usr/bin/perl
use strict;
use warnings;

sub insertionSort{
   	my (@array) = @_;
   	my $index = 0;
	foreach my $outer (0..$#array-1){
		if ($array[$outer]>$array[$outer+1]){
			my $var = $array[$outer+1];
			foreach my $inner (reverse 0..$outer){
				if ($array[$inner]>$var){
					swap(\@array,$inner,$inner+1);
					$index ++;
				}
			}
		}
   }
   return "$index\n";
}

sub swap
{
	my($array,$index1,$index2) = @_;

	my $tmp = $array->[$index1];
	$array->[$index1] = $array->[$index2];
	$array->[$index2] = $tmp;
}

# Tail starts here
my $testcases = <>;
while (1..$testcases){
	my $array_size = <>;
	my @array = split(' ',<>);
	chomp @array;
	print insertionSort(@array);
}
