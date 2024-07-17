package com.amk.cucumber.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amk.cucumber.utility.SeleniumCore;

import net.minidev.json.JSONArray;

public class Parser {

    protected static final String DIGIT_AND_MINUS_REGEX = "[^0-9?!\\.^\\d-]";
    protected static final Logger LOG = LoggerFactory.getLogger(Parser.class.getName());

    public List<Double> convertListWebElementToDouble(List<WebElement> valuesOfCells) {
        return valuesOfCells.stream()
                .map(this::parseValueFromWebElement)
                .collect(Collectors.toList());
    }

    public List<String> convertListWebElementToString(List<WebElement> valuesOfCells) {
        return valuesOfCells.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public Double parseValueFromWebElement(WebElement element) {
        String textToParse = element.getText();
        return parseValue(textToParse);
    }

    public double parseValueByXpath(SeleniumCore seleniumCore, By xpath) {
        String textToParse = seleniumCore.findElement(xpath).getText();
        return parseValue(textToParse);
    }

    /**
     * Try to parse input text into double value
     *
     * @param textToParse
     * @return Double value or 0.0D
     *
     */
    public Double parseValue(String textToParse) {
        try {
            return Double.parseDouble(
                    textToParse.replaceFirst("−", "-").replaceFirst("[(]", "-")
                            .replaceAll(DIGIT_AND_MINUS_REGEX, "")
            );
        } catch (NumberFormatException nfe) {
            LOG.error("Parsing value exception", nfe.getMessage());
            return 0.0D;
        }
    }

    public List<Double> parseListValues(List<String> list) {
        return list.stream()
                .map(str -> parseValue(str))
                .collect(Collectors.toList());
    }

    public List<String> parseJSONArrayToListOfStrings(JSONArray jsonArray) {
        return jsonArray.stream()
                .map(val -> (String) val)
                .collect(Collectors.toList());
    }

    public List<Date> parseListToDate(List<String> list, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        List<Date> dateList = new ArrayList<>();

        try {
            for (String dateString : list) {
                dateList.add(simpleDateFormat.parse(dateString));
            }
        } catch (ParseException pe) {
            LOG.error("Parsing value exception", pe.getMessage());
        }

        return dateList;
    }

    public List<String> parseRemoveSpecialSymbols(List<String> list) {
        int i = 0;
        for (String s : list) {
            s = s.replaceAll("-", "");
            list.set(i, s);
            i++;
        }
        return list;
    }

    public String parseStrToDate(String dateStr) {
        return dateStr.replaceAll("[a-zA-Z]", "").trim();
    }

    public List<Integer> parseListDatesToYears(List<String> dates) {
        return dates.stream()
                .map(date -> date.split("/"))
                .map(str -> Integer.parseInt(str[2]))
                .collect(Collectors.toList());
    }
}
