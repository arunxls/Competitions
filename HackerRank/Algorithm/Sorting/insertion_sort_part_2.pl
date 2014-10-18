#!/usr/bin/perl
use strict;
use warnings;

sub insertionSort{
   	my (@array) = @_;

	foreach my $outer (0..$#array-1){
		if ($array[$outer]>$array[$outer+1]){
			my $var = $array[$outer+1];
			foreach my $inner (reverse 0..$outer){
				if ($array[$inner]>$var){
					swap(\@array,$inner,$inner+1);
				}
			}
		}
		print_array(@array);
   }
}

sub swap
{
	my($array,$index1,$index2) = @_;

	my $one = $array->[$index1];
	my $two = $array->[$index2];
	$array->[$index1] = $two;
	$array->[$index2] = $one;
	return 0;
}
sub print_array
{
	my (@array) = @_;

	foreach (@array){
		chomp($_);
		print $_." ";
	}
	print "\n";
}
# Tail starts here
my $array_size = <>;
my @array = ();
$/ = ' ';
for (my $i = 0; $i < $array_size; $i++) {
   $array[$i] = int(<>);
}

insertionSort(@array);