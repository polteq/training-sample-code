import os

from selenium import webdriver

from enum import Enum, auto


class Browser(Enum):
    CHROME = auto()
    EDGE = auto()
    FIREFOX = auto()


class DriverFactory:

    @classmethod
    def _create_chrome_driver(cls):
        return webdriver.Chrome()

    @classmethod
    def _create_firefox_driver(cls):
        return webdriver.Firefox()

    @classmethod
    def _create_edge_driver(cls):
        return webdriver.Edge()

    @classmethod
    def create_driver(cls, browser):
        os.environ['WDM_LOG_LEVEL'] = '0'
        match browser:
            case Browser.CHROME:
                return cls._create_chrome_driver()
            case Browser.EDGE:
                return cls._create_edge_driver()
            case _:
                return cls._create_firefox_driver()
